package com.nnp.common.abs.features.domainvalues.service;

import com.nnp.common.abs.features.domainvalues.entity.ConfigDomain;
import com.nnp.common.abs.features.domainvalues.repo.ConfigDomainRepository;
import com.nnp.common.abs.features.domainvalues.vo.ConfigDomainSetVO;
import com.nnp.common.abs.features.domainvalues.vo.ConfigDomainVO;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.TreeMap;

@Service
@Slf4j
public class ConfigDomainServiceImpl implements IConfigDomainService {

	@Autowired
	private ConfigDomainRepository configDomainRepository;

	public ConfigDomainSetVO fetchDomains(){
		ConfigDomainSetVO cfgSet = new ConfigDomainSetVO();

		configDomainRepository.findAllOrdered().ifPresent(rcfgs-> {
			this.fillDomainSet(cfgSet ,rcfgs);
		});
		return cfgSet;
	}

	private void fillDomainSet(ConfigDomainSetVO cfgSet, List<ConfigDomain> rcfgs){
		String name = "";
		for(ConfigDomain rcfg : rcfgs){
			if(!rcfg.getName().equals(name)){
				name = rcfg.getName();
				cfgSet.put(name, new TreeMap<>());
			}
			TreeMap<String, ConfigDomainVO> values = cfgSet.get(name);
			ConfigDomainVO vo = new ConfigDomainVO();
			vo.setLabel(rcfg.getLabel() != null ? rcfg.getLabel() : rcfg.getKey());
			vo.setSequence(rcfg.getSequence());
			vo.setDefaultKey(rcfg.getDefaultKey());
			values.put(rcfg.getKey(), vo);
			if(rcfg.getChildren()!= null && !rcfg.getChildren().isEmpty()){
				vo.setChildren(new ConfigDomainSetVO());
				this.fillDomainSet(vo.getChildren(), rcfg.getChildren());
			}
		};
	}
}
