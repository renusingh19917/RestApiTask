package com.dev.task.dao;

import org.springframework.data.repository.CrudRepository;

import com.dev.task.entities.Device;

public interface DeviceRepository extends CrudRepository<Device, Integer>{
  public Device findById(int id);
}
