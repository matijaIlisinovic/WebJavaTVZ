package hr.tvz.ilisinovic.hardwareapp.scheduler;

import hr.tvz.ilisinovic.hardwareapp.model.Hardware;
import hr.tvz.ilisinovic.hardwareapp.repositories.JdbcHardwareRepository;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PrintHardwareJob implements Job {
    @Autowired
    private JdbcHardwareRepository hardwareRepository;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        List<Hardware> hardwares = hardwareRepository.findAll();
        System.out.println("Ovo su trenutno dostupni hardveri:");
        System.out.println("----------------------------------");
        for(Hardware h : hardwares){
            if(h.getNumberOf()>0){
                System.out.println(h.getName()+" - "+h.getNumberOf());
            }
        }
        System.out.println("----------------------------------");
    }
}
