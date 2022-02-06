import {inject} from '@loopback/core';
import {DefaultCrudRepository} from '@loopback/repository';
import {MySqlDatasourceDataSource} from '../datasources';
import {Gym, GymRelations} from '../models';

export class GymRepository extends DefaultCrudRepository<
  Gym,
  typeof Gym.prototype.ID,
  GymRelations
> {
  constructor(
    @inject('datasources.MySqlDatasource') dataSource: MySqlDatasourceDataSource,
  ) {
    super(Gym, dataSource);
  }
}
