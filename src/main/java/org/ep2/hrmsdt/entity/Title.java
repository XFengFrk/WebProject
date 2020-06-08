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
@TableName("t_title")
public class Title implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 职称ID
     */
    @TableId(value = "N_TITLE_ID", type = IdType.AUTO)
    private Integer id;

    /**
     * 职称名称
     */
    @TableField("VC_TITLE_NAME")
    private String name;

    /**
     * 职称编号
     */
    @TableField("VC_TITLE_CODE")
    private String code;

    /**
     * 职称资格
     */
    @TableField("VC_QUALIFICATION")
    private String qualification;

    /**
     * 职称职责
     */
    @TableField("VC_DUTY")
    private String duty;

    /**
     * 工作目标
     */
    @TableField("VC_WORK_TARGET")
    private String target;


}
