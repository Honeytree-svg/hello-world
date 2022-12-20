package hutool;

/**
 * @author : sz
 * @Description :
 * @date : 2022-06-24 13:12
 **/

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @Author: wy
 * @Date: Created in 12:43 2020/6/11
 * @Description:
 * @Modified: By：
 */
@Data
public class YhJbxxVo implements Serializable {

    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
    @JsonSerialize(using = ToStringSerializer.class)
    private Long userId;

    public void setId(Long id) {
        this.id = id;
        this.userId = id;
    }

    /**
     * 用户昵称（客户端显示的名字，默认同用户名）
     */
    private String yhnc;

    /**
     * 用户姓名
     */
    private String yhxm;
    /**
     * 出生日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GTM+8")
    private Date csrq;
    /**
     * 用户头像url
     */
    private String yhtx;

    /**
     * 用户名
     */
    private String yhm;

    /**
     * 所属机构编号
     */
    private String ssjgbh;

    /**
     * 所属机构名称
     */
    private String ssjgmc;

    /**
     * 用户域编号
     */
    private String yhy;

    /**
     * 用户职务
     */
    private String yhzw;

    /**
     * 用户职称
     */
    private String yhzc;

    /**
     * 用户职位
     */
    private String yhzwei;

    /**
     * 医生资格证书编号
     */
    private String yszgzsbh;

    /**
     * 职业证书编号
     */
    private String zyzsbh;

    /**
     * 用户擅长
     */
    private String yhsc;

    /**
     * 备注
     */
    private String bz;

    /**
     * 医生签证照片
     */
    private String ysqz;

    /**
     * 身份证号（用户唯一身份识别）
     */
    private String sfzh;

    /**
     * 环信聊天账号
     */
    private String hxid;

    /**
     * 账号类型（0：出厂账号SuperAdmin，1：微信公众号账号，2.医生账号 9：实施账号，如新昌Admin，99：鉴权账号，如百度）
     */
    private Integer zhlx;

    /**
     * token过期时间（单位：分钟）
     */
    private Integer tkgqsj;

    /**
     * 创建人id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long cjrid;

    /**
     * 创建人姓名
     */
    private String cjrxm;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date cjsj;

    /**
     * 修改人id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long xgrid;

    /**
     * 修改人姓名
     */
    private String xgrxm;

    /**
     * 修改时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date xgsj;

    /**
     * 手机号码
     */
    private String sjhm;
    /**
     * appid
     */
    private String appid;

    /**
     * 启用禁用  (0：禁用，1：启用 )
     */
    private Integer qyjy;

    /**
     * 执业机构json
     */
    private String zyjg;

    /**
     * 科室
     */
    private String ysks;

    /**
     * 办公电话
     */
    private String bgdh;

    /**
     * 工号
     */
    private String gh;

    private String yhymc;
    /**
     * 执业机构(结构化的)
     */

    private String zyjgConcat;

    private String aa;

    private String ab;
}
