package org.ep2.hrmsdt.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

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
@TableName("t_employee")
public class Employee implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 员工信息ID
     */
    @TableId(value = "N_EMP_ID", type = IdType.AUTO)
    private Integer id;

    /**
     * 部门ID
     */
    @TableField("N_DEPT_ID")
    private Integer departmentId;

    /**
     * 职称ID
     */
    @TableField("N_TITLE_ID")
    private Integer titleId;

    /**
     * 岗位ID
     */
    @TableField("N_POST_ID")
    private Integer postId;

    /**
     * 员工姓名
     */
    @TableField("VC_EMP_NAME")
    private String name;

    /**
     * 员工编号
     */
    @TableField("VC_EMP_CODE")
    private String code;

    /**
     * 员工性别
     */
    @TableField("N_GENDER")
    private Integer gender;

    /**
     * 身份证号
     */
    @TableField("VC_IDCARD_CODE")
    private String idCardCode;

    /**
     * 出身年月
     */
    @TableField("D_BIRTHDAY")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    /**
     * 员工籍贯
     */
    @TableField("VC_NATIVE_PLACE")
    private String nativePlace;

    /**
     * 员工学历
     */
    @TableField("N_EDU_LEVEL")
    private Integer educationLevel;

    /**
     * 民族
     */
    @TableField("N_NATION")
    private Integer nation;

    /**
     * 政治面貌
     */
    @TableField("N_PARTY")
    private Integer party;

    /**
     * 健康状况
     */
    @TableField("N_HEALTH")
    private Integer health;

    /**
     * 户口类型
     */
    @TableField("N_REG_TYPE")
    private Integer regType;

    /**
     * 工作状态
     */
    @TableField("N_STATUS")
    private Integer status;


}
