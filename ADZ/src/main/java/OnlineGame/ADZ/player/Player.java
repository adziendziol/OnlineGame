package OnlineGame.ADZ.player;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;


import OnlineGame.ADZ.building.buildingTypeEnum;

@Entity
@Table(name = "RT_PLAYER")
@EntityListeners(AuditingEntityListener.class)
public class Player {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	private String Name;
	
	@NotBlank
	private String email;
}
