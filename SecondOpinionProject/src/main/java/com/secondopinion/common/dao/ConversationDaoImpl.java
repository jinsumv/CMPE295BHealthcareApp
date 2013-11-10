package com.secondopinion.common.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.secondopinion.common.model.Comment;
import com.secondopinion.common.model.Conversation;
import com.secondopinion.common.model.Doctor;
import com.secondopinion.common.model.User;

@Component
public class ConversationDaoImpl implements ConversationDao{

	@Autowired
	private DataSource dataSource;

	@Override
	public void createConversation(Conversation conversation) {
		String sql = "INSERT INTO conversation " +
				"(PATIENT_ID, DOCTOR_ID, TITLE, START_DATE, UPDATE_DATE, UNANSWERED) " +
				"VALUES (?, ?, ?, ?, ?, ?)";
		Connection conn = null;
 
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, conversation.getPatientId());
			if (conversation.getDoctorId() != null)
				ps.setInt(2, conversation.getDoctorId());
			else 
				ps.setNull(2, Types.INTEGER);
			ps.setString(3, conversation.getTitle());
			ps.setTimestamp(4, new java.sql.Timestamp(conversation.getStartDate().getTime()));
			ps.setTimestamp(5, new java.sql.Timestamp(conversation.getUpdateDate().getTime()));
			ps.setBoolean(6, conversation.isUnAnswered());
			ps.executeUpdate();
			ps.close();
 
		} catch (SQLException e) {
			throw new RuntimeException(e);
 
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
	}

	@Override
	public void addComment(Conversation conversation, Comment comment) {
		String sql = "INSERT INTO comment " +
				"(CONVERSATION_ID, USER_ID, TEXT, COMMENT_DATE) " +
				"VALUES (?, ?, ?, ?)";
		Connection conn = null;
 
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, conversation.getConversationId());
			ps.setInt(2, comment.getUserId());
			ps.setString(3, comment.getText());
			ps.setTimestamp(4, new java.sql.Timestamp(comment.getCommentDate().getTime()));
			ps.executeUpdate();
			ps.close();
 
		} catch (SQLException e) {
			throw new RuntimeException(e);
 
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}	
	}
	
	@Override
	public Conversation getNewConversation() {
		String sql = "SELECT * FROM conversation ORDER BY CONVERSATION_ID DESC LIMIT 1";
		 
		Connection conn = null;
 
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			Conversation conversation = null;
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				conversation = new Conversation(
					rs.getInt("CONVERSATION_ID"),
					rs.getInt("PATIENT_ID"),
					rs.getInt("DOCTOR_ID"),
					rs.getString("TITLE"),
					rs.getTimestamp("START_DATE"),
					rs.getTimestamp("UPDATE_DATE"),
					rs.getBoolean("UNANSWERED")
				);
			}
			rs.close();
			ps.close();
			return conversation;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
				conn.close();
				} catch (SQLException e) {}
			}
		}
	}

	@Override
	public Conversation getConversationForConversationId(int conversationId) {
		String sql = "SELECT * FROM conversation WHERE CONVERSATION_ID=?";
		 
		Connection conn = null;
 
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, conversationId);
			Conversation conversation = null;
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				conversation = new Conversation(
					rs.getInt("CONVERSATION_ID"),
					rs.getInt("PATIENT_ID"),
					rs.getInt("DOCTOR_ID"),
					rs.getString("TITLE"),
					rs.getTimestamp("START_DATE"),
					rs.getTimestamp("UPDATE_DATE"),
					rs.getBoolean("UNANSWERED")
				);
			}
			rs.close();
			ps.close();
			return conversation;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
				conn.close();
				} catch (SQLException e) {}
			}
		}
	}

	@Override
	public List<Comment> getCommentsForConversationId(int conversationId) {
		String sql = "SELECT * FROM comment WHERE CONVERSATION_ID=? ORDER BY COMMENT_DATE ASC";
		 
		Connection conn = null;
 
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, conversationId);
			List<Comment> commentList = new ArrayList<Comment>();
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Comment comment= new Comment(
					rs.getInt("COMMENT_ID"),
					rs.getInt("CONVERSATION_ID"),
					rs.getInt("USER_ID"),
					rs.getString("TEXT"),
					rs.getTimestamp("COMMENT_DATE")
				);
				commentList.add(comment);
			}
			rs.close();
			ps.close();
			return commentList;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
				conn.close();
				} catch (SQLException e) {}
			}
		}
	}

	@Override
	public List<Conversation> getAllConversationsForPatient(int patientId) {
		String sql = "SELECT * FROM conversation WHERE PATIENT_ID=? ORDER BY START_DATE DESC";
		 
		Connection conn = null;
 
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, patientId);
			List<Conversation> conversationList = new ArrayList<Conversation>();
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Conversation conversation = new Conversation(
					rs.getInt("CONVERSATION_ID"),
					rs.getInt("PATIENT_ID"),
					rs.getInt("DOCTOR_ID"),
					rs.getString("TITLE"),
					rs.getTimestamp("START_DATE"),
					rs.getTimestamp("UPDATE_DATE"),
					rs.getBoolean("UNANSWERED")
				);
				conversationList.add(conversation);
			}
			rs.close();
			ps.close();
			return conversationList;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
				conn.close();
				} catch (SQLException e) {}
			}
		}
	}
	
	@Override
	public List<Conversation> getAllConversationsInvolvingUser(int userId, int doctorId) {
		String sql = "SELECT * FROM conversation "
				+ "WHERE CONVERSATION_ID IN (SELECT DISTINCT CONVERSATION_ID FROM comment WHERE USER_ID=?) "
				+ "OR DOCTOR_ID=? "
				+ "ORDER BY START_DATE DESC";
		 
		Connection conn = null;
 
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userId);
			ps.setInt(2, doctorId);
			List<Conversation> conversationList = new ArrayList<Conversation>();
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Conversation conversation = new Conversation(
					rs.getInt("CONVERSATION_ID"),
					rs.getInt("PATIENT_ID"),
					rs.getInt("DOCTOR_ID"),
					rs.getString("TITLE"),
					rs.getTimestamp("START_DATE"),
					rs.getTimestamp("UPDATE_DATE"),
					rs.getBoolean("UNANSWERED")
				);
				conversationList.add(conversation);
			}
			rs.close();
			ps.close();
			return conversationList;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
				conn.close();
				} catch (SQLException e) {}
			}
		}
	}
	
	@Override
	public List<Conversation> getMostRecentConversations() {
		String sql = "SELECT * FROM conversation WHERE DOCTOR_ID IS NULL ORDER BY START_DATE DESC";
		 
		Connection conn = null;
 
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			List<Conversation> conversationList = new ArrayList<Conversation>();
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Conversation conversation = new Conversation(
					rs.getInt("CONVERSATION_ID"),
					rs.getInt("PATIENT_ID"),
					rs.getInt("DOCTOR_ID"),
					rs.getString("TITLE"),
					rs.getTimestamp("START_DATE"),
					rs.getTimestamp("UPDATE_DATE"),
					rs.getBoolean("UNANSWERED")
				);
				conversationList.add(conversation);
			}
			rs.close();
			ps.close();
			return conversationList;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
				conn.close();
				} catch (SQLException e) {}
			}
		}
	}
	
	

}
