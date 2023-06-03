package hu.gde.runnersdemo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class DataLoader implements CommandLineRunner {

    private final RunnerRepository runnerRepository;
    private final SponsorRepository sponsorRepository;

    @Autowired
    public DataLoader(RunnerRepository runnerRepository, SponsorRepository sponsorRepository) {
        this.runnerRepository = runnerRepository;
        this.sponsorRepository = sponsorRepository;
    }

    @Override
    public void run(String... args) {
        RunnerEntity runnerEntity = new RunnerEntity();
        runnerEntity.setRunnerName("Tomi");
        runnerEntity.setAveragePace(310);
        runnerEntity.setHeight(185);

        LapTimeEntity laptime1 = new LapTimeEntity();
        laptime1.setLapNumber(1);
        laptime1.setTimeSeconds(120);
        laptime1.setRunner(runnerEntity);

        LapTimeEntity laptime2 = new LapTimeEntity();
        laptime2.setLapNumber(2);
        laptime2.setTimeSeconds(110);
        laptime2.setRunner(runnerEntity);

        runnerEntity.getLaptimes().add(laptime1);
        runnerEntity.getLaptimes().add(laptime2);

        SponsorEntity sponsor1 = new SponsorEntity();
        sponsor1.setSponsorName("Adidas");
        sponsor1 = sponsorRepository.save(sponsor1);

        runnerEntity.setSponsor(sponsor1);

        runnerRepository.save(runnerEntity);

        RunnerEntity runnerEntity2 = new RunnerEntity();
        runnerEntity2.setRunnerName("Zsuzsi");
        runnerEntity2.setAveragePace(290);
        runnerEntity2.setHeight(190);

        LapTimeEntity laptime3 = new LapTimeEntity();
        laptime3.setLapNumber(1);
        laptime3.setTimeSeconds(95);
        laptime3.setRunner(runnerEntity2);

        LapTimeEntity laptime4 = new LapTimeEntity();
        laptime4.setLapNumber(2);
        laptime4.setTimeSeconds(100);
        laptime4.setRunner(runnerEntity2);

        runnerEntity2.getLaptimes().add(laptime3);
        runnerEntity2.getLaptimes().add(laptime4);

        SponsorEntity sponsor2 = new SponsorEntity();
        sponsor2.setSponsorName("Nike");
        sponsor2 = sponsorRepository.save(sponsor2);

        runnerEntity2.setSponsor(sponsor2);

        runnerRepository.save(runnerEntity2);

        //3. futó
        RunnerEntity runnerEntity3 = new RunnerEntity();
        runnerEntity3.setRunnerName("Anna");
        runnerEntity3.setAveragePace(300);
        runnerEntity3.setHeight(182);

        LapTimeEntity laptime5 = new LapTimeEntity();
        laptime5.setLapNumber(1);
        laptime5.setTimeSeconds(90);
        laptime5.setRunner(runnerEntity3);

        runnerEntity3.getLaptimes().add(laptime5);

        SponsorEntity sponsor3 = new SponsorEntity();
        sponsor3.setSponsorName("Puma");
        sponsor3 = sponsorRepository.save(sponsor3);

        runnerEntity3.setSponsor(sponsor3);

        runnerRepository.save(runnerEntity3);
    }
}

