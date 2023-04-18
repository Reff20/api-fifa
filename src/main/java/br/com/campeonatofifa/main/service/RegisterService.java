package br.com.campeonatofifa.main.service;

import br.com.campeonatofifa.main.dto.request.RegisterPlayer;
import br.com.campeonatofifa.main.dto.response.Response;
import br.com.campeonatofifa.main.model.OrganizationModel;
import br.com.campeonatofifa.main.model.PlayerModel;
import br.com.campeonatofifa.main.repository.OrganizationRepository;
import br.com.campeonatofifa.main.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class RegisterService {

    private final PlayerRepository playerRepository;
    private final OrganizationRepository organizationRepository;

    @Autowired
    public RegisterService(PlayerRepository playerRepository, OrganizationRepository organizationRepository) {
        this.playerRepository = playerRepository;
        this.organizationRepository = organizationRepository;
    }

    public ResponseEntity<Object> registerPlayer(RegisterPlayer newPlayer) {
        Response resp = new Response();
        try {
            if (!(newPlayer.getPlayer().isEmpty() || newPlayer.getTag().isEmpty() || newPlayer.getTeam().isEmpty())) {

                Optional<PlayerModel> pName = playerRepository.findByPlayerName(newPlayer.getPlayer());
                Optional<PlayerModel> pTeam = playerRepository.findByPlayerTeamName(newPlayer.getTeam());
                Optional<PlayerModel> pTag = playerRepository.findByPlayerTeamTag(newPlayer.getTag());

                if (!pName.isPresent()) {
                    resp.setMessage("ERROR: This 'Player Name' is already taken.");
                    resp.setStatus(400);
                    return new ResponseEntity<>(resp, HttpStatus.BAD_REQUEST);
                }
                if (!pTeam.isPresent()) {
                    resp.setMessage("ERROR: This 'Team Name' is already taken.");
                    resp.setStatus(400);
                    return new ResponseEntity<>(resp, HttpStatus.BAD_REQUEST);
                }
                if (!pTag.isPresent()) {
                    resp.setMessage("ERROR: This 'Team Tag' is already taken.");
                    resp.setStatus(400);
                    return new ResponseEntity<>(resp, HttpStatus.BAD_REQUEST);
                }
                if (newPlayer.getTag().length() > 4 || newPlayer.getTag().length() < 3) {
                    resp.setMessage("ERROR: This 'Team Tag' are too big or short.");
                    resp.setStatus(400);
                    return new ResponseEntity<>(resp, HttpStatus.BAD_REQUEST);
                }
                Date now = new Date();
                PlayerModel p = new PlayerModel();
                OrganizationModel o = new OrganizationModel();
                p.setPlayerName(newPlayer.getPlayer());
                p.setPlayerScore(0);
                p.setPlayerDateCreated(now);
                p.setPlayerOrgCode(o);
                p.setPlayerTeamName(newPlayer.getTeam());
                p.setPlayerTeamTag(newPlayer.getTag());
                List<PlayerModel> list = new ArrayList<>();
                list.add(p);
                o.setOrgCode(list);
                playerRepository.save(p);
                resp.setMessage("SUCCESS: Player created!");
                resp.setStatus(201);
                return new ResponseEntity<>(resp, HttpStatus.CREATED);
            } else {
                resp.setMessage("ERROR: These fields are empty.");
                resp.setStatus(400);
                return new ResponseEntity<>(resp, HttpStatus.BAD_REQUEST);
            }
        } catch (Exception ex) {
            resp.setMessage("ERROR: Bad Request -> " + ex);
            resp.setStatus(400);
            return new ResponseEntity<>(resp, HttpStatus.BAD_REQUEST);
        }
    }
}
