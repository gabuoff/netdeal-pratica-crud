'use strict';

describe('ColaboradorApp.version module', function() {
  beforeEach(module('ColaboradorApp.version'));

  describe('version service', function() {
    it('should return current version', inject(function(version) {
      expect(version).toEqual('0.1');
    }));
  });
});