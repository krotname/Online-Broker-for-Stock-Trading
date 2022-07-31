package name.krot.exchange.scheduler;

import org.springframework.scheduling.annotation.Scheduled;

public class SchedulerBounds {
    @Scheduled(fixedDelay = 1000)
    public void scheduleFixedDelayTask() {
        System.out.println(
                "Fixed delay task - " + System.currentTimeMillis() / 1000);
                // todo рандомно менять цену акций
    }
}
