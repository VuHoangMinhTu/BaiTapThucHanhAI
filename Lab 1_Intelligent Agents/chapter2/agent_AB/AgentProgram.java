package chapter2.agent_AB;

import static chapter2.agent_AB.Environment.*;

public class AgentProgram {

	public Action execute(Percept p) {// location, status
		//TODO
		Environment.LocationState status = p.getLocationState();
         String location = p.getAgentLocation();

	     if(status == Environment.LocationState.DIRTY) {
           return SUCK_DIRT;
		 }
		 if(location.equals(LOCATION_A) ) {
            return MOVE_RIGHT;
		 }
		 if(location.equals(LOCATION_B)) {
			 return MOVE_LEFT;
		 }

        return null;
    }
}