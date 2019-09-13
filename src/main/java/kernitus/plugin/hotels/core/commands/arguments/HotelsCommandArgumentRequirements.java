package kernitus.plugin.hotels.core.commands.arguments;

/**
 * Defines certain requirements a hotels subcommand argument must meet before being run
 * These include being owner or renter of the specified room or hotel etc.
 */
public class HotelsCommandArgumentRequirements {

    private final HotelsCommandArgumentRequirementsEnum requirement;

    public HotelsCommandArgumentRequirements(HotelsCommandArgumentRequirementsEnum requirement) {
        this.requirement = requirement;
    }

    public HotelsCommandArgumentRequirementsEnum getRequirement() {
        return requirement;
    }
}
