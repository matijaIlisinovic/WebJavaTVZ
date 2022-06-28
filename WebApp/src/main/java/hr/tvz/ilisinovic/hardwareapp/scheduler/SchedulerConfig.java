package hr.tvz.ilisinovic.hardwareapp.scheduler;

import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SchedulerConfig {
    @Bean
    public JobDetail objavaJobDetail(){
        return JobBuilder.newJob(PrintHardwareJob.class).withIdentity("printHardwareJob").storeDurably().build();
    }

    @Bean
    public Trigger objavaJobTrigger() {
        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule("0 0 * * 6-0");
        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
                .withIntervalInSeconds(10).repeatForever();
        return TriggerBuilder.newTrigger().forJob(objavaJobDetail())
                .withIdentity("printHardwareTrigger").withSchedule(scheduleBuilder).build();
    }

}
