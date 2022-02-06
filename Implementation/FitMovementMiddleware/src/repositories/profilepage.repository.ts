import {inject} from '@loopback/core';
import {DefaultCrudRepository} from '@loopback/repository';
import {MySqlDatasourceDataSource} from '../datasources';
import {Profilepage, ProfilepageRelations} from '../models';

export class ProfilepageRepository extends DefaultCrudRepository<
  Profilepage,
  typeof Profilepage.prototype.USERNAME,
  ProfilepageRelations
> {
  constructor(
    @inject('datasources.MySqlDatasource') dataSource: MySqlDatasourceDataSource,
  ) {
    super(Profilepage, dataSource);
  }
}
