package com.inditex.pot.slc.utils.commons.bean;

import com.inditex.pot.slc.utils.commons.exceptions.model.Error;
import lombok.Builder;
import lombok.Data;


public class Response<T> {
    private T data;
    private Error errors;
}
