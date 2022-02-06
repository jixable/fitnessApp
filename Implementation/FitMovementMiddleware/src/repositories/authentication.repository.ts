import {inject} from '@loopback/core';
import {DefaultCrudRepository} from '@loopback/repository';
import {MySqlDatasourceDataSource} from '../datasources';
import {Authentication, AuthenticationRelations} from '../models';

export class AuthenticationRepository extends DefaultCrudRepository<
  Authentication,
  typeof Authentication.prototype.USERNAME,
  AuthenticationRelations
> {
  constructor(
    @inject('datasources.MySqlDatasource') dataSource: MySqlDatasourceDataSource,
  ) {
    super(Authentication, dataSource);
  }
}
