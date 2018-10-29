package OnlineGame.ADZ.ressource;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import OnlineGame.ADZ.player.Player;

@Entity
@Table(name = "RT_Ressources")
@EntityListeners(AuditingEntityListener.class)
public class RessourceBalance {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	private Long amount;

	@ManyToOne
	@JoinColumn(name = "playerID")
	private Player player;

	@NotNull
	@Enumerated(EnumType.STRING)
	private RessourceTypeEnum ressourceType;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public RessourceTypeEnum getRessourceType() {
		return ressourceType;
	}

	public void setRessourceType(RessourceTypeEnum ressourceType) {
		this.ressourceType = ressourceType;
	}
}
