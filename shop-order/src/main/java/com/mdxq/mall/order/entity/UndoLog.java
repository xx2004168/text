package com.mdxq.mall.order.entity;

import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import java.io.Serializable;
import java.time.LocalDateTime;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *  实体类。
 *
 * @author XuXin
 * @since 2025-08-11
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(value = "undo_log", schema = "md_mall_order")
public class UndoLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id(keyType = KeyType.Auto)
    private Long id;

    private Long branchId;

    private String xid;

    private String context;

    private byte[] rollbackInfo;

    private Integer logStatus;

    private LocalDateTime logCreated;

    private LocalDateTime logModified;

    private String ext;

}
