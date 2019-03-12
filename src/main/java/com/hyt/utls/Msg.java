package com.hyt.utls;

public class Msg {
//    1 代表成功 0代表失败
    private Integer code;
    private Object data;

    public Msg() {
    }

    public Msg(Integer code) {
        this.code = code;
    }

    public Msg(Integer code, Object data) {
        this.code = code;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Msg{" +
                "code=" + code +
                ", data=" + data +
                '}';
    }
}
