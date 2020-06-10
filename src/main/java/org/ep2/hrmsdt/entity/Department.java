package org.ep2.hrmsdt.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author nepsyn
 * @since 2020-06-07
 */
@Data
@EqualsAndHashCode()
@Accessors(chain = true)
@TableName("t_dept")
public class Department implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 部门ID
     */
    @TableId(value = "N_DEPT_ID", type = IdType.AUTO)
    private Integer id;

    /**
     * 部门编号
     */
    @TableField("VC_DEPT_CODE")
    private String code;

    /**
     * 部门名称
     */
    @TableField("VC_DEPT_NAME")
    private String name;

    /**
     * 部门类型
     */
    @TableField("N_DEPT_TYPE")
    private Integer type;

    /**
     * 上级部门ID
     */
    @TableField("N_PARENT_ID")
    private Integer parentId;

    /**
     * 地址
     */
    @TableField("VC_LOCATION")
    private String location;

    /**
     * 邮编
     */
    @TableField("VC_POST_CODE")
    private String postcode;

    /**
     * 联系电话
     */
    @TableField("VC_TELEPHONE")
    private String telephone;

    /**
     * 传真
     */
    @TableField("VC_FAX")
    private String fax;

    /**
     * 电子邮件
     */
    @TableField("VC_MAIL")
    private String mail;

}
