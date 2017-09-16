package edu.unsw.comp9323.bot.service.impl;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.unsw.comp9323.bot.dao.ReminderDao;
import edu.unsw.comp9323.bot.model.Reminder;
import edu.unsw.comp9323.bot.service.ReminderService;
import edu.unsw.comp9323.bot.service.impl.AIWebhookServiceImpl.AIWebhookRequest;


@Service
public class ReminderServiceImpl implements ReminderService {
	
	@Autowired
	ReminderDao reminderDao;

	@Override
	public List<Reminder> getAllReminders(AIWebhookRequest input) {
		// TODO Auto-generated method stub
		return reminderDao.findReminderById((long) 1);
	}

	@Override
	public boolean deleteReminder(AIWebhookRequest input) {
		// TODO Auto-generated method stub
		if(reminderDao.findReminderById((long) 2) == null){
			return false;//no such reminder
		}else {
			if(reminderDao.deleteReminder((long)2))
				return true;//delete successfully
			else
				return false;//fail to delete
		}
		
	}

	@Override
	public boolean addReminder(AIWebhookRequest input) {
		// TODO Auto-generated method stub
		Reminder newReminder = new Reminder();
		newReminder.setDate(new Date(System.currentTimeMillis()));
		newReminder.setContent("1111");
		newReminder.setOwner("z5032760");
		newReminder.setTitle("2222");
		if(reminderDao.insertReminder(newReminder))
			return true;
		else
			return false;
	}

	@Override
	public boolean remindByEmail(AIWebhookRequest input) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateReminder(AIWebhookRequest input) {
		// TODO Auto-generated method stub
		Reminder newReminder = new Reminder();
		newReminder.setDate(new Date(System.currentTimeMillis()));
		newReminder.setContent("1111");
		newReminder.setOwner("z5032760");
		newReminder.setTitle("2222");
		if(reminderDao.findReminderById((long)2) == null){
			return false;//no such reminder
		}else {
			if(reminderDao.updateReminder(newReminder))
				return true;//delete successfully
			else
				return false;//fail to delete
		}
	}




}
