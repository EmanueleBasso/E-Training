package it.unisa.etraining.controller.offerteformative;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import it.unisa.etraining.model.bean.TutorDidattico;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestVisualizzaProposteOfferteFormativeEsterneServlet {
  
  @Mock
  HttpServletRequest request;
  @Mock
  HttpServletResponse response;
  @Mock
  HttpSession sessione;
  @Mock
  RequestDispatcher dispatcher;
  
  @Before
  public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void test01_SenzaSessione() throws Exception {
    when(request.getRequestDispatcher("/login.jsp")).thenReturn(dispatcher);    
    try {
      new VisualizzaProposteOfferteFormativeEsterneServlet().doGet(request, response);      
    } catch(NullPointerException e) {
      assertTrue(false);
      return;
    }    
    assertTrue(true);
  }
  
  @Test
  public void test02_Successo() throws Exception {
    when(request.getSession(false)).thenReturn(sessione);
    when(sessione.getAttribute("utente")).thenReturn(new TutorDidattico());
    when(request.getRequestDispatcher("/paginaErrore.jsp?errore=Errore nel connettersi al database.")).thenReturn(dispatcher);    
    try {
      new VisualizzaProposteOfferteFormativeEsterneServlet().doGet(request, response);      
    } catch(NullPointerException e) {
      assertTrue(false);
      return;
    }    
    assertTrue(true);
  }

}
