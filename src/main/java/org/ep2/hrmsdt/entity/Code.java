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
@TableName("t_code")
public class Code implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "N_CODE_ID", type = IdType.AUTO)
    private Integer id;

    /**
     * 预选项组
     */
    @TableField("VC_CODE_LABEL")
    private String label;

    /**
     * 预选项值
     */
    @TableField("VC_CODE_VALUE")
    private String value;

    /**
     * 是否可删除
     */
    @TableField("N_REMOVABLE")
    private Integer removable;


}
