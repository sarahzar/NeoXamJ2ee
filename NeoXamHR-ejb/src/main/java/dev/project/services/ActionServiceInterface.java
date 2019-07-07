package dev.project.services;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import dev.project.entities.Action;
@Remote
public interface ActionServiceInterface {

	Action getActionById(String id);

	boolean AddAction(Action act);

	List<Action> getAllActions();

	Action GetActionByCode(String code);

	Action getActionByDate(Date d);

	boolean UpdateAction(String Id, Action A);

	boolean DeleteAction(String Id);

}
