package by.bsuir.firmclient.rmi;

import by.bsuir.firmserver.rmi.Announcement;
import by.bsuir.firmserver.rmi.RemoteCommand;
import by.bsuir.firmserver.rmi.RemoteCustomCommand;
import by.bsuir.firmserver.rmi.RemoteValidatedCommand;
import by.bsuir.firmserver.subjectarea.*;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Commander{
    public RemoteCommand<Firm> getFirms ;
    public RemoteCommand<Firm> updateFirm;
    public RemoteCommand<Firm> addFirm;
    public RemoteCommand<Firm> deleteFirm;
    
    public RemoteCommand<User> getUsers ;
    public RemoteCommand<User> updateUser;
    public RemoteCommand<User> addUser;
    public RemoteCommand<User> deleteUser;
    
    public RemoteCommand<Review> getReviews;
    public RemoteCommand<Review> updateReview;
    public RemoteCommand<Review> addReview;
    public RemoteCommand<Review> deleteReview;
    
    public RemoteCommand<Perfomance> getPerfomances ;
    public RemoteCommand<Perfomance> updatePerfomance;
    public RemoteCommand<Perfomance> addPerfomance;
    public RemoteCommand<Perfomance> deletePerfomance;
    
    public RemoteCustomCommand getUserFirm;
    public RemoteCustomCommand getFirmPerfomance;
    public RemoteCustomCommand deleteUserLogin;
    
    public RemoteValidatedCommand registerUser;
    public RemoteValidatedCommand loginUser;
    
    public RemoteValidatedCommand registerFirm;
    
    private final Registry registry;

    public Commander() throws RemoteException, NotBoundException {
        registry = LocateRegistry.getRegistry(Announcement.HOST_NAME, Announcement.HOST_PORT);
        getFirms = (RemoteCommand) registry.lookup(Announcement.GET_FIRMS);
        updateFirm = (RemoteCommand) registry.lookup(Announcement.UPDATE_FIRM);
        addFirm = (RemoteCommand) registry.lookup(Announcement.ADD_FIRM);
        deleteFirm = (RemoteCommand) registry.lookup(Announcement.DELETE_FIRM);
        
        getUsers = (RemoteCommand) registry.lookup(Announcement.GET_USERS);
        updateUser = (RemoteCommand) registry.lookup(Announcement.UPDATE_USER);
        addUser = (RemoteCommand) registry.lookup(Announcement.ADD_USER);
        deleteUser = (RemoteCommand) registry.lookup(Announcement.DELETE_USER);
        
        getReviews = (RemoteCommand) registry.lookup(Announcement.GET_REVIEWS);
        updateReview = (RemoteCommand) registry.lookup(Announcement.UPDATE_REVIEW);
        addReview = (RemoteCommand) registry.lookup(Announcement.ADD_REVIEW);
        deleteReview = (RemoteCommand) registry.lookup(Announcement.DELETE_REVIEW);
        
        getPerfomances = (RemoteCommand) registry.lookup(Announcement.GET_PERFOMANCES);
        updatePerfomance = (RemoteCommand) registry.lookup(Announcement.UPDATE_PERFOMANCE);
        addPerfomance = (RemoteCommand) registry.lookup(Announcement.ADD_PERFOMANCE);
        deletePerfomance = (RemoteCommand) registry.lookup(Announcement.DELETE_PERFOMANCE);
        
        registerUser = (RemoteValidatedCommand) registry.lookup(Announcement.REGISTER_USER);
        loginUser = (RemoteValidatedCommand) registry.lookup(Announcement.LOGIN_USER);
        
        getUserFirm = (RemoteCustomCommand) registry.lookup(Announcement.GET_USER_FIRM);
        getFirmPerfomance = (RemoteCustomCommand) registry.lookup(Announcement.GET_FIRM_PERFOMANCE);
        
        deleteUserLogin = (RemoteCustomCommand) registry.lookup(Announcement.DELETE_USER_LOGIN);
        
        registerFirm = (RemoteValidatedCommand) registry.lookup(Announcement.REGISTER_FIRM);
    }
}
