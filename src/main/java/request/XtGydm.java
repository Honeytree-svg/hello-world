package request;

import lombok.Data;

import java.util.Date;

/**
 * 系统-公用代码
 */
@Data
public class XtGydm {
    private static final long serialVersionUID = 1L;
    /**
     * 主键ID
     */
    private Long id;

    /**
     * 代码类别ID
     */
    private String dmlbid;

    /**
     * 代码类别名称
     */
    private String dmlbmc;

    /**
     * 代码ID
     */
    private String dmid;

    /**
     * 代码名称
     */
    private String dmmc;

    /**
     * 顺序号
     */
    private Integer sxh;

    /**
     * 拼音码
     */
    private String pym;

    /**
     * 默认标志（1：默认值；0：非默认值）
     */
    private Boolean mrbj;

    /**
     * 扩展字段1
     */
    private String kz1;

    /**
     * 扩展字段2
     */
    private String kz2;

    /**
     * 扩展字段3
     */
    private String kz3;

    /**
     * 用户域编号
     */
    private String yhybh;

    /**
     * 最近修改时间戳
     */
    private Long zjxgsjc;

    /**
     * 作废标志（0：正常；1：作废）
     */
    private Boolean zfbz;

    /**
     * 数据来源
     */
    private String sjly;

    /**
     * 创建人ID
     */
    private Long cjrid;

    /**
     * 创建人姓名
     */
    private String cjrxm;

    /**
     * 创建时间
     */
    private Date cjsj;

    /**
     * 修改人ID
     */
    private Long xgrid;

    /**
     * 修改人姓名
     */
    private String xgrxm;

    /**
     * 修改时间
     */
    private Date xgsj;
}