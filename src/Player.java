public class Player {
    private String userName;
    private String desiredTime;

    public String toString()
    {
        return userName;
    }
    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getDesiredTime() {
        return desiredTime;
    }

    public void setDesiredTime(String time)
    {
        desiredTime = time;
    }
}
