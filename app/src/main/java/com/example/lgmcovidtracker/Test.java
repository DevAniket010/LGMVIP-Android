package com.example.lgmcovidtracker;

public class Test {
    private String State,confirmed,deaths,recovered,Total;



    public Test(String state, String confirmed, String deaths, String recovered,
                 String Total)
    {
        State=state;
        this.confirmed = confirmed;
        this.deaths = deaths;
        this.recovered = recovered;
        this.Total = Total;

    }

    public String getState()
    {
        return State;
    }

    public void setState(String state)
    {
        State=state;
    }

    public String getConfirmed()
    {
        return confirmed;
    }

    public void setConfirmed(String confirmed)
    {
        this.confirmed = confirmed;
    }

    public String getDeaths()
    {
        return deaths;
    }

    public void setDeaths(String deaths)
    {
        this.deaths = deaths;
    }

    public String getRecovered()
    {
        return recovered;
    }

    public void setRecovered(String recovered)
    {
        this.recovered = recovered;
    }

    public String getTotal()
    {
        return Total;
    }

    public void setTotal(String Total)
    {
        this.Total = Total;
    }


}

