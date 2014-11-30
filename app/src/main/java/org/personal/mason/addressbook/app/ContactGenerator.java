package org.personal.mason.addressbook.app;

import org.axonframework.commandhandling.CommandBus;
import org.axonframework.commandhandling.GenericCommandMessage;
import org.axonframework.domain.IdentifierFactory;
import org.personal.mason.addressbook.app.command.CreateContactCommand;
import org.personal.mason.addressbook.app.command.RegisterAddressCommand;
import org.personal.mason.addressbook.app.type.AddressType;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * <p>Uses the sample api to create some sample content</p>
 *
 * @author Allard Buijze
 */
public class ContactGenerator implements ApplicationListener {

    private CommandBus commandBus;
    private AtomicBoolean initialized = new AtomicBoolean();

    public ContactGenerator(CommandBus commandBus) {
        this.commandBus = commandBus;
    }

    public void onApplicationEvent(ApplicationEvent event) {
        if (!initialized.get() && event instanceof ContextRefreshedEvent) {
            initializeData();
        }
    }

    public void initializeData() {
        if (initialized.compareAndSet(false, true)) {
            String allardContactId = IdentifierFactory.getInstance().generateIdentifier();
            CreateContactCommand commandAllard = new CreateContactCommand(
                    allardContactId,
                    "Allard"
            );
            commandBus.dispatch(new GenericCommandMessage<Object>(commandAllard));

            String jettroContactId = IdentifierFactory.getInstance().generateIdentifier();
            CreateContactCommand commandJettro = new CreateContactCommand(
                    jettroContactId,
                    "Jettro"
            );
            commandBus.dispatch(new GenericCommandMessage<Object>(commandJettro));

            RegisterAddressCommand registerPrivateAddressCommand = new RegisterAddressCommand(
                    allardContactId,
                    AddressType.PRIVATE,
                    "AxonBoulevard 1",
                    "1234AB",
                    "The Hague"
            );
            commandBus.dispatch(new GenericCommandMessage<Object>(registerPrivateAddressCommand));

            RegisterAddressCommand registerWorkAddressCommand = new RegisterAddressCommand(
                    allardContactId,
                    AddressType.WORK,
                    "JTeam avenue",
                    "1234AB",
                    "Amsterdam"
            );
            commandBus.dispatch(new GenericCommandMessage<Object>(registerWorkAddressCommand));

            RegisterAddressCommand registerJettroAddressCommand = new RegisterAddressCommand(
                    jettroContactId,
                    AddressType.PRIVATE,
                    "Feyenoordlaan 010",
                    "3000AA",
                    "Rotterdam"
            );
            commandBus.dispatch(new GenericCommandMessage<Object>(registerJettroAddressCommand));
        }
    }
}
