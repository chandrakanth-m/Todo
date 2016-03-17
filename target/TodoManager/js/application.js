/*
 ********************************************************************************
 Copyright 2011-2014 Ellucian Company L.P. and its affiliates.
 ********************************************************************************

 var Ajax;
 if (Ajax && (Ajax != null)) {
 Ajax.Responders.register({
 onCreate: function() {
 if($('spinner') && Ajax.activeRequestCount>0)
 Effect.Appear('spinner',{duration:0.5,queue:'end'});
 },
 onComplete: function() {
 if($('spinner') && Ajax.activeRequestCount==0)
 Effect.Fade('spinner',{duration:0.5,queue:'end'});
 }
 });
 }

 if (typeof jQuery !== 'undefined') {

 var todoApp = angular.module('todoApp',['ngResource']);
 }
 */

if (typeof jQuery !== 'undefined') {

  var todoApp = angular.module('todoApp', ['ngRoute','ngResource','ui.bootstrap']);
}


