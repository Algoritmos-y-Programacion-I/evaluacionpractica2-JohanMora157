package model;

public class Controller {

    private Pillar[] pillars;

    public Controller() {

        pillars = new Pillar[4];

    }

    /**
     * Descripcion: Permite crear y añadir un Project en un Pillar en el sistema
     * 
     * @return boolean true si se logra añadir el Prject en el Pillar, false en caso
     *         contrario
     */
    public boolean registerProjectInPillar(int pillarType, String id, String name, String description, boolean status) {

        Project project = new Project(id, name, description, status);
        if (pillars[pillarType - 1] != null) {
            pillars[pillarType - 1].registerProject(project);
        }

        return true;
    }

    /**
     * Descripcion: Calcula el valor en dinero correspondiente al arrendamiento
     * mensual de todos los Edificios
     * pre: El arreglo edificios debe estar inicializado
     * 
     * @return String cadena en formato lista con la información de los
     *         Project registrados en el Pillar
     */
    public String queryProjectsByPillar(int pillarType) {
        String query = "";
        if (pillars[pillarType - 1] != null) {
            query = pillars[pillarType - 1].getProjectList();

        }
        return "Pilar " + pillars[pillarType - 1].getName() + ":\n" + query;
    }

    public void preUpPillar() {

        Pillar pillar1 = new Pillar("BIODIVERSIDA");
        Pillar pillar2 = new Pillar("AGUA");
        Pillar pillar3 = new Pillar("TRATAMIENTO DE BASURAS");
        Pillar pillar4 = new Pillar("ENERGIA");

        pillars[0] = pillar1;
        pillars[1] = pillar2;
        pillars[2] = pillar3;
        pillars[3] = pillar4;

    }

}
