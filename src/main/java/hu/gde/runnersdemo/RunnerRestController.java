package hu.gde.runnersdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/runner")
public class RunnerRestController {

    @Autowired
    private LapTimeRepository lapTimeRepository;
    private RunnerRepository runnerRepository;
    private final RunnerService runnerService;
    private final SponsorRepository sponsorRepository;

    @Autowired
    public RunnerRestController(RunnerRepository runnerRepository, LapTimeRepository lapTimeRepository,
                                RunnerService runnerService, SponsorRepository sponsorRepository) {
        this.runnerRepository = runnerRepository;
        this.lapTimeRepository = lapTimeRepository;
        this.runnerService = runnerService;
        this.sponsorRepository = sponsorRepository;
    }

    @GetMapping("/{id}")
    public RunnerEntity getRunner(@PathVariable Long id) {
        return runnerRepository.findById(id).orElse(null);
    }

    @GetMapping("/{id}/averagelaptime")
    public double getAverageLaptime(@PathVariable Long id) {
        RunnerEntity runner = runnerRepository.findById(id).orElse(null);
        if (runner != null) {
            List<LapTimeEntity> laptimes = runner.getLaptimes();
            int totalTime = 0;
            for (LapTimeEntity laptime : laptimes) {
                totalTime += laptime.getTimeSeconds();
            }
            double averageLaptime = (double) totalTime / laptimes.size();
            return averageLaptime;
        } else {
            return -1.0;
        }
    }

    @GetMapping("")
    public List<RunnerEntity> getAllRunners() {
        return runnerRepository.findAll();
    }

    @PostMapping("/{id}/addlaptime")
    public ResponseEntity addLaptime(@PathVariable Long id, @RequestBody LapTimeRequest lapTimeRequest) {
        RunnerEntity runner = runnerRepository.findById(id).orElse(null);
        if (runner != null) {
            LapTimeEntity lapTime = new LapTimeEntity();
            lapTime.setTimeSeconds(lapTimeRequest.getLapTimeSeconds());
            lapTime.setLapNumber(runner.getLaptimes().size() + 1);
            lapTime.setRunner(runner);
            lapTimeRepository.save(lapTime);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Runner with ID " + id + " not found");
        }
    }

    @GetMapping("/highest")
    public ResponseEntity<String> getHighestRunnerName() {
        return ResponseEntity.ok(runnerService.getHighestRunner().getRunnerName());
    }

    @PutMapping("/{runnerId}/sponsor/{sponsorId}")
    public ResponseEntity<?> addSponsorToRunner(
            @PathVariable(name = "runnerId") Long runnerId,
            @PathVariable(name = "sponsorId") Long sponsorId
    ) {
        RunnerEntity runner = runnerRepository.findById(runnerId).orElse(null);
        SponsorEntity sponsor = sponsorRepository.findById(sponsorId).orElse(null);
        if (runner == null || sponsor == null) {
            if(runner == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Runner with ID " + runnerId + " not found");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Sponsor with ID " + sponsorId + " not found");
            }
        } else {
            runner.setSponsor(sponsor);
            runnerRepository.save(runner);
        }

        return ResponseEntity.ok().build();
    }

    public static class LapTimeRequest {
        private int lapTimeSeconds;

        public int getLapTimeSeconds() {
            return lapTimeSeconds;
        }

        public void setLapTimeSeconds(int lapTimeSeconds) {
            this.lapTimeSeconds = lapTimeSeconds;
        }
    }
}
