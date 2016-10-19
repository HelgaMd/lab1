package com.vittach;

/**
 * Created by VITTACH on 18.10.2016
 * @author Zharikov Vitaliy- vk.com
 * @version 0.3.2
 */
class NegativeException extends Exception
{
    private static final long serialVersionUID = 1L;
    public NegativeException(String msg){
        super(msg);
    }
}
