public class Analytics {
    private int activeSessions;
    private int currentPlayers;
    private int weeklySessions;
    private int weeklyPlayers;
    private int monthlySessions;
    private int monthlyPlayers;
    private int yearlySessions;
    private int yearlyPlayers;

    public Analytics(int activeSessions, int currentPlayers, int weeklySessions, int weeklyPlayers, int monthlySessions, int monthlyPlayers, int yearlySessions, int yearlyPlayers)
    {
        this.activeSessions = activeSessions;
        this.currentPlayers = currentPlayers;
        this.weeklySessions = weeklySessions;
        this.weeklyPlayers = weeklyPlayers;
        this.monthlySessions = monthlySessions;
        this.monthlyPlayers = monthlyPlayers;
        this.yearlySessions = activeSessions;
        this.yearlySessions = yearlySessions;
        this.yearlyPlayers = yearlyPlayers;
    }
    public Analytics()
    {

    }

    public int getActiveSessions() {
        return activeSessions;
    }
    public int getCurrentPlayers() {
        return currentPlayers;
    }

    public int getMonthlyPlayers() {
        return monthlyPlayers;
    }

    public int getMonthlySessions() {
        return monthlySessions;
    }

    public int getWeeklyPlayers() {
        return weeklyPlayers;
    }

    public int getWeeklySessions() {
        return weeklySessions;
    }

    public int getYearlyPlayers() {
        return yearlyPlayers;
    }

    public int getYearlySessions() {
        return yearlySessions;
    }

    public void setActiveSessions(int activeSessions) {
        this.activeSessions = activeSessions;
    }

    public void setCurrentPlayers(int currentPlayers) {
        this.currentPlayers = currentPlayers;
    }

    public void setMonthlyPlayers(int monthlyPlayers) {
        this.monthlyPlayers = monthlyPlayers;
    }

    public void setMonthlySessions(int monthlySessions) {
        this.monthlySessions = monthlySessions;
    }

    public void setWeeklyPlayers(int weeklyPlayers) {
        this.weeklyPlayers = weeklyPlayers;
    }

    public void setWeeklySessions(int weeklySessions) {
        this.weeklySessions = weeklySessions;
    }

    public void setYearlyPlayers(int yearlyPlayers) {
        this.yearlyPlayers = yearlyPlayers;
    }

    public void setYearlySessions(int yearlySessions) {
        this.yearlySessions = yearlySessions;
    }
}
