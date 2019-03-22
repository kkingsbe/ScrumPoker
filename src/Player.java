public class Player {
    private String userName;
    private String desiredTime = "none";

    public Player(String userName)
    {
        this.userName = userName;
    }
    public String toString()
    {
        return userName;
    }
    public void setUserName(String userName)
    {
        this.userName = userName;
    }
    public String getUserName() {
        return userName;
    }
    public String getDesiredTime() {
        return desiredTime;
    }
    public void setDesiredTime(String time)
    {
        desiredTime = time;
    }
    public void resetVote()
    {
        desiredTime = "none";
    }
}
