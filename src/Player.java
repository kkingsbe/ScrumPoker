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
    public void setUserName(String userName) //sets/gets username
    {
        this.userName = userName;
    }
    public String getUserName() {
        return userName;
    }
    public String getDesiredTime() { //gets votes
        return desiredTime;
    }
    public void setDesiredTime(String time) //votes
    {
        desiredTime = time;
    }
    public void resetVote() //restarts the vote
    {
        desiredTime = "none";
    }
}
