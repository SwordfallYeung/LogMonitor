package cn.itcast.logMonitor.domain;

/**
 * Describe: 请补充类描述
 */
public class App {
    private int id;//应用编号
    private String name;//应用名称
    private int isOnline;//应用是否在线
    private int typeId;//应用所属类别
    private String userId;//应用的负责人，多个用户用逗号分开

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIsOnline() {
        return isOnline;
    }

    public void setIsOnline(int isOnline) {
        this.isOnline = isOnline;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "App{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", isOnline=" + isOnline +
                ", typeId=" + typeId +
                ", userId='" + userId + '\'' +
                '}';
    }
}
