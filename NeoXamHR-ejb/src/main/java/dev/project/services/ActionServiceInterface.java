package dev.project.services;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Remote;

import dev.project.dao.ActionDaoInterface;
import dev.project.entities.Action;
@Local
public interface ActionServiceInterface extends ActionDaoInterface {


}
