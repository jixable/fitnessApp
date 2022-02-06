import {inject} from '@loopback/core';
import {DefaultCrudRepository} from '@loopback/repository';
import {MySqlDatasourceDataSource} from '../datasources';
import {Friendslist, FriendslistRelations} from '../models';

export class FriendslistRepository extends DefaultCrudRepository<
  Friendslist,
  typeof Friendslist.prototype.ID1,
  FriendslistRelations
> {
  constructor(
    @inject('datasources.MySqlDatasource') dataSource: MySqlDatasourceDataSource,
  ) {
    super(Friendslist, dataSource);
  }
}
