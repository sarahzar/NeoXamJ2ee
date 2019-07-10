package dev.project.dao;

import java.util.Date;

import javax.ejb.Local;

import dev.project.entities.Action;
@Local
public interface ActionDaoInterface extends GenericCRUD<Action> {
	
	Action GetActionByCode(String code);
	Action getActionByDate(Date d);

}
