package com.mecha.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mecha.api.model.Work;
import com.mecha.api.repository.IWorkRepository;
import com.mecha.api.service.interfaces.IWorkService;
import com.mecha.api.exceptions.NotFoundException;

@Service
public class WorkService implements IWorkService {
    
    @Autowired
    private IWorkRepository workRepository;

    @Override
    public List<Work> findAll() {
        return workRepository.findAll();
    }

    @Override
    public Work findById(Long id) {
        return workRepository.findById(id).orElseThrow(() -> new NotFoundException("Work not found"));
    }

    @Override
    public Work save(Work work) {
        workRepository.save(work);
        return work;
    }

    @Override
    public Work update(Long id, Work work) {
        Work workUpdated = this.findById(id);
        workUpdated.setName(work.getName());
        workUpdated.setUnit_price(work.getUnit_price());
        workUpdated.setInvoiceWorks(work.getInvoiceWorks());
        workRepository.save(workUpdated);
        return workUpdated;
    }

    @Override
    public void deleteById(Long id) {
        Work work = this.findById(id);
        workRepository.delete(work);
    }
}
