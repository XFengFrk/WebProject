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
@TableName("t_post")
public class Post implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 岗位ID
     */
    @TableId(value = "N_POST_ID", type = IdType.AUTO)
    private Integer id;

    /**
     * 岗位名称
     */
    @TableField("VC_POST_NAME")
    private String name;

    /**
     * 上级岗位ID
     */
    @TableField("N_PARENT_ID")
    private Integer parentId;

    /**
     * 岗位职责
     */
    @TableField("VC_DUTY")
    private String duty;

    /**
     * 任职资格
     */
    @TableField("VC_QUALIFICATION")
    private String qualification;

    /**
     * 岗位权限
     */
    @TableField("VC_PURVIEW")
    private String purview;

    /**
     * 工作内容
     */
    @TableField("VC_WORK_CONTENT")
    private String content;


}
