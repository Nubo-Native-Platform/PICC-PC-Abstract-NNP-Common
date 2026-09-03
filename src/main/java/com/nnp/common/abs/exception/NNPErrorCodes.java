package com.nnp.common.abs.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum NNPErrorCodes {
    BAD_REQ_PARAM(400, "Bad request parameter"),
    ITEM_NOT_FOUND(404, "Item Not Found"),
    METHOD_NOT_ALLOWED(405, "Mandatory components can not be removed from plan."),
    ITEM_NOT_ACCEPTABLE(406, "Already present. Insert/Update not possible."),
    UN_PROCESSABLE_ENTITY(422, "Unprocessable Entity."),
    UNKNOWN_EXCEPTION(500, "Unknown Internal Error"),
    SERVICE_ERROR(500, "External Service Error");

    private final int code;
    private final String message;
}

