package asia.fourtitude.java.sboot.Product.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class EntityAudit {

	@Column(name = "CREATED_AT", updatable = false, nullable = true, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	@CreatedDate
	@JsonIgnore
	@Temporal(TemporalType.TIMESTAMP)
	protected Date createdDate;


	@JsonFormat(pattern = "dd-MMM-yyyy")
	@Column(name = "UPDATED_AT", nullable = true, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	@LastModifiedDate
	@Temporal(TemporalType.TIMESTAMP)
	protected Date lastModifiedDate;


	public Date getCreatedDate() {
		return createdDate;
	}


	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}


	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}


	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	
}
