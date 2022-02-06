import {
  Count,
  CountSchema,
  Filter,
  FilterExcludingWhere,
  repository,
  Where,
} from '@loopback/repository';
import {
  post,
  param,
  get,
  getModelSchemaRef,
  patch,
  put,
  del,
  requestBody,
  response,
} from '@loopback/rest';
import {Authentication} from '../models';
import {AuthenticationRepository} from '../repositories';

const bcrypt = require('bcrypt');
const saltRounds = 10;

export class AuthenticationController {
  constructor(
    @repository(AuthenticationRepository)
    public authenticationRepository : AuthenticationRepository,
  ) {}

  @post('/authentications')
  @response(200, {
    description: 'Authentication model instance',
    content: {'application/json': {schema: getModelSchemaRef(Authentication)}},
  })
  async create(
    @requestBody({
      content: {
        'application/json': {
          schema: getModelSchemaRef(Authentication, {
            title: 'NewAuthentication',
          }),
        },
      },
    })
    authentication: Authentication,
  ): Promise<Authentication> {
    return bcrypt.hash(authentication.PASS_HASH, saltRounds).then((result: string) => {
      authentication.PASS_HASH = result;
      return this.authenticationRepository.create(authentication)
    });
  }

  @get('/authentications/count')
  @response(200, {
    description: 'Authentication model count',
    content: {'application/json': {schema: CountSchema}},
  })
  async count(
    @param.where(Authentication) where?: Where<Authentication>,
  ): Promise<Count> {
    return this.authenticationRepository.count(where);
  }

  @get('/authentications')
  @response(200, {
    description: 'Array of Authentication model instances',
    content: {
      'application/json': {
        schema: {
          type: 'array',
          items: getModelSchemaRef(Authentication, {includeRelations: true}),
        },
      },
    },
  })
  async find(
    @param.filter(Authentication) filter?: Filter<Authentication>,
  ): Promise<Authentication[]> {
    return this.authenticationRepository.find(filter);
  }

  @patch('/authentications')
  @response(200, {
    description: 'Authentication PATCH success count',
    content: {'application/json': {schema: CountSchema}},
  })
  async updateAll(
    @requestBody({
      content: {
        'application/json': {
          schema: getModelSchemaRef(Authentication, {partial: true}),
        },
      },
    })
    authentication: Authentication,
    @param.where(Authentication) where?: Where<Authentication>,
  ): Promise<Count> {
    return this.authenticationRepository.updateAll(authentication, where);
  }

  @get('/authentications/{id}')
  @response(200, {
    description: 'Authentication model instance',
    content: {
      'application/json': {
        schema: getModelSchemaRef(Authentication, {includeRelations: true}),
      },
    },
  })
  async findById(
    @param.path.string('id') id: string,
    @param.filter(Authentication, {exclude: 'where'}) filter?: FilterExcludingWhere<Authentication>
  ): Promise<Authentication> {
    return this.authenticationRepository.findById(id, filter);
  }

  @patch('/authentications/{id}')
  @response(204, {
    description: 'Authentication PATCH success',
  })
  async updateById(
    @param.path.string('id') id: string,
    @requestBody({
      content: {
        'application/json': {
          schema: getModelSchemaRef(Authentication, {partial: true}),
        },
      },
    })
    authentication: Authentication,
  ): Promise<void> {
    await this.authenticationRepository.updateById(id, authentication);
  }

  @put('/authentications/{id}')
  @response(204, {
    description: 'Authentication PUT success',
  })
  async replaceById(
    @param.path.string('id') id: string,
    @requestBody() authentication: Authentication,
  ): Promise<void> {
    await this.authenticationRepository.replaceById(id, authentication);
  }

  @del('/authentications/{id}')
  @response(204, {
    description: 'Authentication DELETE success',
  })
  async deleteById(@param.path.string('id') id: string): Promise<void> {
    await this.authenticationRepository.deleteById(id);
  }

  @post('/authentications/verify')
  @response(200, {
    description: 'verify password',
    content: {
      'application/json': {
        response: 'boolean'
      },
    },
  })
  async verifyPassword(
    @requestBody({
      content: {
        'application/json': {
          schema: getModelSchemaRef(Authentication, {
            title: 'WeNeedToMakeUpATitleForThis',
          }),
        },
      },
    })
    authentication: Authentication
  ): Promise<Boolean> {
    try {
      var hash = (await this.authenticationRepository.findById(authentication.USERNAME)).PASS_HASH;
    } catch (Exception) {
      // assuming the retrieving a user failed, so return false as the user does not exist then.
      return false;
    }
    return bcrypt.compare(authentication.PASS_HASH, hash).then(function (result: Boolean) {
      return result;
    });
  }
}
