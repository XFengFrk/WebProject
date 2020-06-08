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
@TableName("t_user")
public class User implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 用户ID
     */
    @TableId(value = "N_USER_ID", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户名
     */
    @TableField("VC_USERNAME")
    private String username;

    /**
     * 用户密码
     */
    @TableField("VC_PASSWORD")
    private String password;

    /**
     * 用户角色
     */
    @TableField("N_ROLE")
    private Integer role;


}
