package hu.gde.runnersdemo;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

import java.util.ArrayList;
import java.util.List;

@Entity
public class SponsorEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long sponsorId;
    private String sponsorName;

    @OneToMany(mappedBy = "sponsor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RunnerEntity> runners = new ArrayList<>();

    public SponsorEntity() {
    }

    public long getSponsorId()
    {
        return sponsorId;
    }

    public void setSponsorId(long sponsorId)
    {
        this.sponsorId = sponsorId;
    }

    public String getSponsorName()
    {
        return sponsorName;
    }

    public void setSponsorName(String sponsorName)
    {
        this.sponsorName = sponsorName;
    }

    public List<RunnerEntity> getRunners()
    {
        return runners;
    }

    public void setRunners(List<RunnerEntity> runners)
    {
        this.runners = runners;
    }
}
