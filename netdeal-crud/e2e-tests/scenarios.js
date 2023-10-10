'use strict';

/* https://github.com/angular/protractor/blob/master/docs/toc.md */

describe('ColaboradorApp', function() {


  it('should automatically redirect to /colaborador when location hash/fragment is empty', function() {
    browser.get('index.html');
    expect(browser.getLocationAbsUrl()).toMatch("/colaborador");
  });


  describe('colaborador', function() {

    beforeEach(function() {
      browser.get('index.html#!/colaborador');
    });


    it('should render colaborador when user navigates to /colaborador', function() {
      expect(element.all(by.css('[ng-view] p')).first().getText()).
        toMatch(/partial for view 1/);
    });

  });


  describe('colaborador', function() {

    beforeEach(function() {
      browser.get('index.html#!/view2');
    });


    it('should render colaborador when user navigates to /colaborador', function() {
      expect(element.all(by.css('[ng-view] p')).first().getText()).
        toMatch(/partial for view 2/);
    });

  });
});