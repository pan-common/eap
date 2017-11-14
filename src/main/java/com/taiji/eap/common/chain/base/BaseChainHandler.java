package com.taiji.eap.common.chain.base;

/**
 * 基础责任链
 */
public abstract class BaseChainHandler {

    protected BaseChainHandler nextHandler;//下一个处理类

    protected void doHandler(String type) throws Exception{
        if(isType(type)){
            doEcho();
        }else {
            if(nextHandler!=null){
                nextHandler.doHandler(type);
            }else {
                throw new Exception("未找到处理类");
            }
        }
    }

    /**
     * 处理逻辑
     */
    protected abstract void doEcho();

    /**
     * 判断是否应该进行处理
     * @param type
     * @return
     */
    protected abstract boolean isType(String type);

    public void setNextHandler(BaseChainHandler nextHandler) {
        this.nextHandler = nextHandler;
    }
}
