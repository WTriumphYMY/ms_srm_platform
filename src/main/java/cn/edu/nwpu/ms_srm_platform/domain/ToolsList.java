package cn.edu.nwpu.ms_srm_platform.domain;

import javax.persistence.*;

@Entity
@Table(name = "tb_toolslist")
public class ToolsList {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "toolid")
    private Integer toolId;

    @Column(name = "toolalias")
    private String toolAlias;

    @Column(name = "toolname")
    private String toolName;

    @Column(name = "toolauthor")
    private String toolAuthor;

    @Column(name = "tooldesc")
    private String toolDesc;

    public Integer getToolId() {
        return toolId;
    }

    public void setToolId(Integer toolId) {
        this.toolId = toolId;
    }

    public String getToolName() {
        return toolName;
    }

    public void setToolName(String toolName) {
        this.toolName = toolName;
    }

    public String getToolAuthor() {
        return toolAuthor;
    }

    public void setToolAuthor(String toolAuthor) {
        this.toolAuthor = toolAuthor;
    }

    public String getToolDesc() {
        return toolDesc;
    }

    public void setToolDesc(String toolDesc) {
        this.toolDesc = toolDesc;
    }

    public String getToolAlias() {
        return toolAlias;
    }

    public void setToolAlias(String toolAlias) {
        this.toolAlias = toolAlias;
    }
}
