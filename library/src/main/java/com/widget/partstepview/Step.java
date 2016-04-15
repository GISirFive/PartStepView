package com.widget.partstepview;

/**
 * stepview以圆点为界，分别向上、向下延伸出两条线，以和其它的步骤连接；
 * 通过设置Step，来控制这两条线的显示和隐藏
 * Created by GISirFive on 2016-4-14.
 */
public enum Step {
    /**开始节点，隐藏向上的连接线*/
    START(0),
    /**中间的阶段，显示两根连接线*/
    MIDDLE(1),
    /**结束节点，隐藏向下的连接线*/
    END(2),
    /**不参与步骤，隐藏两根连接线*/
    NONE(3);

    int code;//每个步骤对应的编号

    Step(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
